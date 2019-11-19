import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, FormGroup } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { map } from 'rxjs/operators';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ListComponent } from './list/list.component'; 
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown-angular7';
import { RoutineComponent } from './routine/routine.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MaterialModule} from './material/material.module';
import { ScehduelComponent } from './routine/scehduel/scehduel.component'  //made module for material 
import { ScheduelService } from './routine/scheduel.service';
import { ScheduleeditComponent } from './routine/scheduleedit/scheduleedit.component';
import {A11yModule} from '@angular/cdk/a11y';
import {DragDropModule} from '@angular/cdk/drag-drop';
import {PortalModule} from '@angular/cdk/portal';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {CdkStepperModule} from '@angular/cdk/stepper';
import {CdkTableModule} from '@angular/cdk/table';
import {CdkTreeModule} from '@angular/cdk/tree';
import { DataService } from './routine/dataservice.service';
import { DeletedialogComponent } from './routine/deletedialog/deletedialog.component';
import { AuthenticateComponent } from './authenticate/authenticate/authenticate.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { IntercepterService } from './intercepter.service';
import { UploaddownloadfileComponent } from './upload/uploaddownloadfile/uploaddownloadfile.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListComponent,
    RoutineComponent,
    ScehduelComponent,
    ScheduleeditComponent,
    DeletedialogComponent,
    AuthenticateComponent,
    UploaddownloadfileComponent
  ],
  imports: [
    MaterialModule,
    BrowserModule,
    Ng2SearchPipeModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AngularMultiSelectModule,
    NgMultiSelectDropDownModule,
    BrowserAnimationsModule,
    A11yModule,
    CdkStepperModule,
    CdkTableModule,
    CdkTreeModule,
    DragDropModule,
    PortalModule,
    ScrollingModule,

  ], exports: [
    AngularMultiSelectModule,
    NgMultiSelectDropDownModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: IntercepterService,
      multi: true
    },
    ScheduelService,,DataService],
  bootstrap: [AppComponent],
  entryComponents:[ScehduelComponent,ScheduleeditComponent,DeletedialogComponent]
 
})
export class AppModule { 
  }
