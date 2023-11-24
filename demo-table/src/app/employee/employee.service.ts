import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable  } from 'rxjs';
import { Employee } from '../models/employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private urlApi = environment.apiUrl+"/employees";

  private httpOptions ={
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Allow-Origin': '*'
    })
  }
  constructor(private http: HttpClient) { }
  getEmployee(): Observable<Employee[]>{

    return this.http.get<Employee[]>(this.urlApi,this.httpOptions);
  }
}
