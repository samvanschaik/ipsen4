import {Injectable} from '@angular/core';
import {Follower_model} from '../models/Follower_model';
import {Observable } from 'rxjs/Observable';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Injectable()
export class FollowersService {
  constructor(private http: HttpClient) {
  }

  getFollowerInformation() {
    return this.http.get('http://localhost:8080/api/followers/0');
  }
}
