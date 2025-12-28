import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { KeynoteService } from '../../services/keynote.service';
import { Keynote } from '../../models/keynote.model';
import { CommonModule } from '@angular/common';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-keynotes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './keynotes.component.html',
  styleUrls: ['./keynotes.component.css']
})
export class KeynotesComponent implements OnInit {
  keynotes: Keynote[] = [];
  isAdmin = false;

  constructor(private keynoteService: KeynoteService, private cdr: ChangeDetectorRef, private keycloakService: KeycloakService) { }

  ngOnInit(): void {
    this.isAdmin = this.keycloakService.getUserRoles().includes('ADMIN');
    this.keynoteService.getAllKeynotes().subscribe({
      next: (data) => {
        console.log('Keynotes received:', data);
        this.keynotes = data;
        this.cdr.detectChanges();
      },
      error: (err) => console.error(err)
    });
  }
}
