import { Component, OnInit } from '@angular/core';
import { ConferenceService } from '../../services/conference.service';
import { KeynoteService } from '../../services/keynote.service';
import { Conference } from '../../models/conference.model';
import { CommonModule } from '@angular/common';

import { ChangeDetectorRef } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-conferences',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './conferences.component.html',
  styleUrls: ['./conferences.component.css']
})
export class ConferencesComponent implements OnInit {
  conferences: Conference[] = [];
  isAdmin = false;

  constructor(private conferenceService: ConferenceService, private keynoteService: KeynoteService, private cdr: ChangeDetectorRef, private keycloakService: KeycloakService) { }

  ngOnInit(): void {
    this.isAdmin = this.keycloakService.getUserRoles().includes('ADMIN');
    this.conferenceService.getAllConferences().subscribe({
      next: (data) => {
        console.log('Conferences received:', data);
        this.conferences = data;
        this.cdr.detectChanges(); // Force update
        // Fetch missing Keynotes manually if backend didn't enrich them
        this.conferences.forEach(c => {
          if (!c.keynote && c.keynoteId) {
            this.keynoteService.getKeynoteById(c.keynoteId).subscribe({
              next: (k) => {
                c.keynote = k;
                this.cdr.detectChanges(); // Force update on enrichment
              },
              error: (err) => console.error('Error fetching keynote for conference ' + c.id, err)
            });
          }
        });
      },
      error: (err) => console.error(err)
    });
  }
}
