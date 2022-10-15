import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobTitleRoutingModule } from './job-title-routing.module';
import { JobTitleComponent } from './job-title/job-title.component';
import { UpdateJobTitleComponent } from './update-job-title/update-job-title.component';
import { AddJobTitleComponent } from './add-job-title/add-job-title.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { NgSelectModule } from '@ng-select/ng-select';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    JobTitleComponent,
    UpdateJobTitleComponent,
    AddJobTitleComponent
  ],
  imports: [
    CommonModule,
    JobTitleRoutingModule,
    SharedModule,
    NgSelectModule,
    MatTableModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatInputModule,
    NgSelectModule,
    NgxDatatableModule,
    NgbModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class JobTitleModule { }
