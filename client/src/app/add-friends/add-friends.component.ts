import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/add-friends.service';

@Component({
  selector: 'app-add-friends',
  standalone: true,
  imports: [],
  templateUrl: './add-friends.component.html',
  styleUrls: ['./add-friends.component.css']
})
export class AddFriendsComponent implements OnInit {
  users: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getUsers().subscribe((data) => {
      this.users = data;
    });
  }
}