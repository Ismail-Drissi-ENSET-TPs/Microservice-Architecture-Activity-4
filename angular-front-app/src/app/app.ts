import { Component, signal, OnInit } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('angular-front-app');
  username: string | undefined;

  constructor(private keycloakService: KeycloakService) { }

  async ngOnInit() {
    if (await this.keycloakService.isLoggedIn()) {
      const profile = await this.keycloakService.loadUserProfile();
      this.username = profile.username;
    }
  }

  logout() {
    this.keycloakService.logout();
  }
}
