import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { InsuranceCompany } from '../insurance-company/insurance-company';
import { JobTitle } from '../job-title/job-title';
import { Employee, EmployeeJobInformation } from './employee';
import { EmployeeQualification, EmployeeBank, EmployeeInsuranceCompany, EmployeeJobTitle, EmployeeUniversity, EmployeeMajor, Address } from './employee';

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

  public addEmployee(employee: Employee): Observable<Employee[]>{
    return this.http.post<Employee[]>(`${this.apiServerUrl}/employee/add`,employee)
  }

  public getAddressById(): Observable<Address[]>{
    return this.http.get<Address[]>(`${this.apiServerUrl}/address/all`)
  }

  public getAllEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`)
  }

  public getAllJobTitles(): Observable<JobTitle[]>{
    return this.http.get<JobTitle[]>(`${this.apiServerUrl}/jobTitle/all`)
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

  public addEmployeeQualification(employeeQualification: EmployeeQualification): Observable<EmployeeQualification[]>{
    return this.http.post<EmployeeQualification[]>(`${this.apiServerUrl}/employeeQualification/add`,employeeQualification)
  }

  public addJobInfo(empJobInformation: EmployeeJobInformation): Observable<EmployeeJobInformation[]>{
    return this.http.post<EmployeeJobInformation[]>(`${this.apiServerUrl}/jobInfo/add`,empJobInformation)
  }

  public addAddress(address: Address): Observable<Address[]>{
    return this.http.post<Address[]>(`${this.apiServerUrl}/address/add`,address)
  }

  public addEmployeeBank(employeeBank: EmployeeBank): Observable<EmployeeBank[]>{
    return this.http.post<EmployeeBank[]>(`${this.apiServerUrl}/employeeBank/add`,employeeBank)
  }

  public addEmployeeInsuranceCompany(employeeInsuranceCompany: EmployeeInsuranceCompany): Observable<EmployeeInsuranceCompany[]>{
    return this.http.post<EmployeeInsuranceCompany[]>(`${this.apiServerUrl}/employeeInsuranceCompany/add`,employeeInsuranceCompany)
  }

  public addEmployeeJobTitle(employeeJobTitle: EmployeeJobTitle): Observable<EmployeeJobTitle[]>{
    return this.http.post<EmployeeJobTitle[]>(`${this.apiServerUrl}/employeeJobTitle/add`,employeeJobTitle)
  }

  public addEmployeeUniversity(employeeUniversity: EmployeeUniversity): Observable<EmployeeUniversity[]>{
    return this.http.post<EmployeeUniversity[]>(`${this.apiServerUrl}/employeeUniversity/add`,employeeUniversity)
  }

  public addEmployeeMajor(employeeMajor: EmployeeMajor): Observable<EmployeeMajor[]>{
    return this.http.post<EmployeeMajor[]>(`${this.apiServerUrl}/employeeMajor/add`,employeeMajor)
  }

  
  public getBanksByEmployeeId(employeeId: any): Observable<EmployeeBank[]>{
    return this.http.get<EmployeeBank[]>(`${this.apiServerUrl}/employeeBank/find/${employeeId}`)
  }

  public getInsuranceCompaniesByEmployeeId(employeeId: any): Observable<EmployeeInsuranceCompany[]>{
    return this.http.get<EmployeeInsuranceCompany[]>(`${this.apiServerUrl}/employeeInsuranceCompany/find/${employeeId}`)
  }

  public getQualificationsByEmployeeId(employeeId: any): Observable<EmployeeQualification[]>{
    return this.http.get<EmployeeQualification[]>(`${this.apiServerUrl}/employeeQualification/find/${employeeId}`)
  }

  public getJobsInformationByEmployeeId(employeeId: any): Observable<EmployeeJobInformation[]>{
    return this.http.get<EmployeeJobInformation[]>(`${this.apiServerUrl}/jobInfo/find/${employeeId}`)
  }

  public deleteEmpBank(empBankId: EmployeeBank): Observable<EmployeeBank>{
    return this.http.put<EmployeeBank>(`${this.apiServerUrl}/employeeBank/delete/${empBankId}`,empBankId);
  }
  
  public deleteAddress(addressId: Address): Observable<Address>{
    return this.http.put<Address>(`${this.apiServerUrl}/address/delete/${addressId}`,addressId);
  }

  public deleteEmpQualification(empQualificationId: EmployeeQualification): Observable<EmployeeQualification>{
    console.log(empQualificationId)
    return this.http.put<EmployeeQualification>(`${this.apiServerUrl}/employeeQualification/delete/${empQualificationId}`,empQualificationId);
  }

  public deleteJobInformation(empJobInformationId: EmployeeJobInformation): Observable<EmployeeJobInformation>{
    console.log(empJobInformationId)
    return this.http.put<EmployeeJobInformation>(`${this.apiServerUrl}/jobInfo/delete/${empJobInformationId}`,empJobInformationId);
  }

  public deleteEmpInsurCom(empInsurComId: EmployeeInsuranceCompany): Observable<InsuranceCompany>{
    return this.http.put<InsuranceCompany>(`${this.apiServerUrl}/employeeInsuranceCompany/delete/${empInsurComId}`,empInsurComId);
  }

}
