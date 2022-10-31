import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginDTO } from 'src/models/logindto';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username!: string;
  public password!: string;

  loginDTO!: LoginDTO;

  constructor(private router: Router, private service: UserService) { }

  public handleSubmit(form: NgForm): void {
    if (form.invalid) {
      return;
    } else {
      this.loginDTO = new LoginDTO(form.value.username, form.value.password);

      this.service.login(this.loginDTO).subscribe((user) => {

        if (user != null) {
          localStorage.setItem('currentUser', JSON.stringify(user));

          switch (user.usertype.toString()) {
            case 'ADMINISTRATOR': {
              this.router.navigate(['/home']);
              break;
            }
            case 'ADMIN': {
              this.router.navigate(['/home']);
              break;
            }
            case 'USER': {
              this.router.navigate(['/home']);
              break;
            }
            default:
              this.router.navigate(['/login']);
          }
        }
      })

    }
  }

  public ngOnInit(): void {
  }
}
