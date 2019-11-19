import { Component, OnInit } from '@angular/core';
import { ScheduelService } from '../scheduel.service';
import { MatDialogRef } from "@angular/material";
import { DataService } from '../dataservice.service';

import { Subscription } from 'rxjs';
@Component({
  selector: 'app-deletedialog',
  templateUrl: './deletedialog.component.html',
  styleUrls: ['./deletedialog.component.css']
})
export class DeletedialogComponent implements OnInit {
  data: String;
pagesize : number
messages: any[] = [];
subscription: Subscription;
  constructor(public service : ScheduelService,public dialogRef:MatDialogRef<DeletedialogComponent>,private dataService: DataService) { 
    this.subscription = this.dataService.getMessage().subscribe(message => {
      if (message) {
        console.log(message)
        this.pagesize = message.text
      } else {
        // clear messages when empty message receive
       this.messages = [];
    }
  })
  }

  ngOnInit() {
  }
  onSubmit() {
    console.log(this.service.form.value.id);
    this.service.deleteOneRowData(this.service.form.value.id,this.pagesize).subscribe(res => {
      this.data = res;
      console.log(res);
    },

    );
    this.onClose();

  }

  onClose() {
   
    this.dialogRef.close();
    
  }
}
