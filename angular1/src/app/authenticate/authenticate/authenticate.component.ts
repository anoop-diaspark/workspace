import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HomeService } from 'src/app/home/home.service';

@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.css']
})
export class AuthenticateComponent implements OnInit {
  auth: FormGroup;
  constructor(private _HomeService: HomeService,private fb: FormBuilder) { }

  ngOnInit() {
    this.auth= this.fb.group({
      userName:[''],
      password:[''],
    

    })
  }

  onSubmit(){
    console.log(this.auth.value);
    this._HomeService.authenticate(this.auth.value).subscribe(res => {
    
      console.log(res);
    },

    );
  }
}
