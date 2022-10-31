import { Injectable } from '@angular/core';
import { AbstractService } from './abstract.service';
import { UserDTO } from 'src/models/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/models/logindto';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

/**
 * I service sono decorati da @Injectable.
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 *
 * @author Vittorio Valent
 *
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO>{
  subscribe(arg0: (val: any) => void, arg1: any, arg2: { let: any; local: number; console: Console; "": any; }, arg3: any, arg4: { if(u: any): any; "": boolean; }) {
    throw new Error('Method not implemented.');
  }

  constructor(http: HttpClient) {
    super(http);
    this.type = 'user';
  }

  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>(environment.APIEndpoint + this.type + '/login', loginDTO)
  }

}
