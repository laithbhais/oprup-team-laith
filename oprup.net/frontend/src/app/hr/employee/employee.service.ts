import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiServerUrl = environment.apiBaseUrl


  constructor(private http: HttpClient) { }


  public upload(formData: FormData): Observable<HttpEvent<string[]>> {
    return this.http.post<string[]>(`${this.apiServerUrl}/file/upload`, formData, {
      reportProgress: true,
      observe: 'events'
    });
  }

  public addEmployee(employee: Employee): Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`,employee)
  }

  public getAllEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`)
  }

  public getEmployeeById(employeeId: any): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/find/${employeeId}`)
  }

  public deleteEmployee(employeeId: Employee): Observable<Employee>{
    return this.http.put<Employee>(`${this.apiServerUrl}/employee/delete/${employeeId}`,employeeId);

  }

  public updateEmployee(employeeId: Employee): Observable<Employee[]>{
    return this.http.put<Employee[]>(`${this.apiServerUrl}/employee/update`, employeeId)
  }
  // public getEmployeeByemployeeTypeId(employeeTypeId: any): Observable<Employee[]>{
  //   return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/find/${employeeTypeId}`)
  // }
}
