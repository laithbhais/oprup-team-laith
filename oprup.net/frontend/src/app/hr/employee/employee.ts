import { EmployeeTypeComponent } from "../employee-type/employee-type/employee-type.component";

export interface Employee {
    employeeId?: number;
    employeeName: string;
    employeeNameAr: string;
    dateOfJoin: string;
    gender: string;
    employeeCode: string;
    image: string;
    placeOfBirth:string;
    dateOfBirth:string;
    nationality:string;
    religion:string;
    maritalStatus:string;
    employeeType:
    {employeeTypeId:number;}
    jobStatus:string;

    deleteFlag: number;
}
