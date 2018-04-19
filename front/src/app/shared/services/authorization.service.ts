import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class AuthorizationService {
  private token: string = null;

  constructor() {
    //
  }

  public hasAuthorization(): boolean {
    return this.token !== null;
  }

  public setAuthorization(username: string, password: string): void {
    this.token = 'Basic ' + btoa(username + ':' + password);
  }

  public storeAuthorization() {
    localStorage.setItem('token', this.token);
  }

  public restoreAuthorization(): void {
    const token = localStorage.getItem('token');
    if (token) {
      this.token = token;
    }
  }

  public deleteAuthorization(): void {
    localStorage.removeItem('token');
    this.token = null;
  }

  public createAuthorizationString(): string {
    return this.token;
  }
}
