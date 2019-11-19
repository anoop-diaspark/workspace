import { Component, OnInit } from '@angular/core';
import { ScheduelService } from '../scheduel.service';
import { MatDialogRef } from "@angular/material";

@Component({
  selector: 'app-scehduel',
  templateUrl: './scehduel.component.html',
  styleUrls: ['./scehduel.component.css'],
  // providers:[ScheduelService]
})
export class ScehduelComponent implements OnInit {
  data: any;

  constructor(   public service : ScheduelService,public dialogRef:MatDialogRef<ScehduelComponent>) { }

  ngOnInit() {
  }
  onClear() {
    
    this.service.form.reset();
    this.service.initializeFormGroup();
  }

  onSubmit() {
    console.log(this.service.form.value);
    this.service.adddetail(this.service.form.value).subscribe(res => {
      this.data = res;
      console.log(res);
    },

    );
    this.onClose();

  }

  onClose() {
    this.service.form.reset();
    this.service.initializeFormGroup();
    this.dialogRef.close();
    
  }
}
