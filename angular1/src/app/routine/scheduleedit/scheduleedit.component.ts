import { Component, OnInit } from '@angular/core';
import { ScheduelService } from '../scheduel.service';
import { MatDialogRef } from "@angular/material";
import { DataService } from '../dataservice.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-scheduleedit',
  templateUrl: './scheduleedit.component.html',
  styleUrls: ['./scheduleedit.component.css'],
  // providers:[ScheduelService]
})
export class ScheduleeditComponent implements OnInit {
  data: String;
id : number
messages: any[] = [];
subscription: Subscription;
  constructor(public service : ScheduelService,public dialogRef:MatDialogRef<ScheduleeditComponent>,private dataService: DataService) {
    this.subscription = this.dataService.getMessage().subscribe(message => {
      if (message) {
        console.log(message)
        this.id = message.text
      } else {
        // clear messages when empty message receive
       this.messages = [];
    }
  })
}

  ngOnInit() {
  }
  onClear() {
    
    this.service.form.reset();
    this.service.initializeFormGroup();
  }

  onSubmit() {
    console.log(this.service.form.value.countryName);
   console.log(this.id)
    this.service.editdetail(this.id,this.service.form.value.countryName,this.service.form.value.matchDate,this.service.form.value.matchType,).subscribe(res => {
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
