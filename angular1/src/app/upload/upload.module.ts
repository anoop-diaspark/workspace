import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UploadRoutingModule } from './upload-routing.module';
import { UploaddownloadfileComponent } from './uploaddownloadfile/uploaddownloadfile.component';


@NgModule({
  declarations: [UploaddownloadfileComponent],
  imports: [
    CommonModule,
    UploadRoutingModule
  ]
})
export class UploadModule { }
