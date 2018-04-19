import { Component, OnInit } from '@angular/core';
import {FollowersService} from '../shared/services/followers.service';
import {Follower_model} from '../shared/models/Follower_model';
import {log} from 'util';

@Component({
  selector: 'app-followers',
  templateUrl: './followers.component.html',
  styleUrls: ['./followers.component.css']
})
export class FollowersComponent implements OnInit {
  followersDay1: Follower_model;

  constructor(private followerservice: FollowersService) {
  }

  ngOnInit() {
    this.getFollowersDay1();
  }

  getFollowersDay1(): void {
    this.followerservice.getFollowerInformation().subscribe(
      data => {this.followersDay1 = data as any; },
      err => console.log(err),
      () => console.log(this.followersDay1)
    );
  }
}
