import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SectionRoutingModule } from './section-routing.module';
import { AddSectionComponent } from './add-section/add-section.component';
import { SectionComponent } from './section/section.component';
import { UpdateSectionComponent } from './update-section/update-section.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgSelectModule } from '@ng-select/ng-select';


@NgModule({
  declarations: [
    SectionComponent,
    AddSectionComponent,
    UpdateSectionComponent
  ],
  imports: [
    CommonModule,
    SectionRoutingModule,
    SharedModule,
    FormsModule,
    // MatFormFieldModule,
    ReactiveFormsModule,
    NgbModule,
    NgSelectModule
  ]
})
export class SectionModule { }
