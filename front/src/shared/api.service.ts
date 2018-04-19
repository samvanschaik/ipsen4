import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {AuthorizationService} from '../app/shared/services/authorization.service';


@Injectable()
export class ApiService {

  constructor(private http: HttpClient, private authService: AuthorizationService) {

  }

  private createQueryString(queryParameters: Object): string {
    let queryString = '';

    if (typeof queryParameters === 'object') {
      for (const key in queryParameters) {

        const value = queryParameters[key];
        const prefix = queryString.length === 0 ? '?' : '&';

        queryString += `${prefix}${key}=${value}`;
      }
    }
    return queryString;
  }

  private createURI(path: string, queryParameters: Object): string {
    const queryString = this.createQueryString(queryParameters);

    return `/api/${path}${queryString}`;
  }

  private createRequestHeaders(): HttpHeaders {
    let headers = new HttpHeaders();

    if (this.authService.hasAuthorization()) {
      headers = headers.set('Authorization', this.authService.createAuthorizationString());
    }

    return headers;
  }

  public get<T>(path: string, queryParameters?: Object): Observable<T> {
    const uri = this.createURI(path, queryParameters);
    const headers = this.createRequestHeaders();

    return this.http.get<T>(uri, { headers: headers });
  }
}
