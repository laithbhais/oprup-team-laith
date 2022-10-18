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
  {
    employeeTypeId:number;
  }
  jobStatus:string;

  deleteFlag: number;
}

export interface EmployeeQualification {
    employee: {
        employeeId: string;
      },
    qualification: {
        qualificationId: string;
      },
      university: {
        universityId: string;
      },
      major: {
          majorId: string;
      }
}

export interface EmployeeJobInformation {
  employee: {
      employeeId: string;
    },
  department: {
    departmentId: string;
    },
    section: {
      sectionId: string;
    },
    jobTitle: {
      jobTitleId: string;
    }
}

export interface EmployeeBank  {
  employee: {
    employeeId: string
  },
  bank: {
      bankId: string,
      // bankName: string
  }
}

export interface EmployeeInsuranceCompany  {
    insurancePolicyNumber: string,
    insurancePolicyType: string,
    issueDate: string,
    expiryDate: string,
    insuranceDegree: string,
    insuranceCompany: {
        insuranceCompanyId: string
    },
    employee: {
        employeeId: string
    }
}

export interface EmployeeJobTitle  {
  employee: {
    employeeId: string
  },
  jobTitle: {
    jobTitleId: string
  }
}

export interface EmployeeUniversity  {
  employee: {
    employeeId: string
  },
  university: {
    universityId: string
  }
}

export interface EmployeeMajor  {
  employee: {
    employeeId: string
  },
  major: {
    majorId: string
  }
}

export interface Address{
  employee: {
    employeeId: any
  },
  addressName: string,
  email: string,
  phoneNumber: string
}

export interface EmployeeExperience{
  employee: {
    employeeId: any
  },
  company: string,
  startDate: string,
  endDate: string,
  position: string
}

export interface EmployeeResidence{
  employee: {
    employeeId: any
  },
  residenceNumber: number,
  jobBYResidence: string,
  residenceIssueDate: string,
  residenceExpiryDate: string,
  sponsorTransferDate: string,
  hijriSponsorTransferDate: string
}