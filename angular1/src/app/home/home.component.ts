import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import{HomeService} from '../home/home.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  registerForm: FormGroup;
  cities: Array<any>;
  codes: Array<any>;


  constructor(private fb: FormBuilder,
    private _HomeService:HomeService)
  { 
  }

  ngOnInit() {
    this.registerForm= this.fb.group({
      countryName:[''],
      stateName:[''],
      countryCode:['']

    })

  }
  countryList: Array<any> = [
    { name: 'Germany', cities: ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn'], codes: [123, 345, 456] },
    { name: 'Spain', cities: ['Barcelona'], codes: [123, 345, 986] },
    { name: 'India', cities: ['Delhi','Punjab',"Bihar"], codes: [123, 345, 986] },
    { name: 'USA', cities: ['Downers Grove', 'Washigton', 'New Mexico'], codes: [123, 385, 456] },
    { name: 'Mexico', cities: ['Puebla'], codes: [123, 345, 389] },
    { name: 'China', cities: ['Beijing'], codes: [23, 345, 456] },
  ];
  changeCountry(count) {
    this.cities = this.countryList.find(con => con.name == count).cities;
    this.codes = this.countryList.find(con => con.name == count).codes;
  }

  logout(){
    this._HomeService.logout();
  }

  save() {
    console.log('user data', this.registerForm.value)
    this._HomeService.registeration(this.registerForm.value).subscribe(data => console.log(data),
      error => console.log(error));
alert("you have successfully registered")

  }
  onSubmit(){
    
    this.save();
  }

}
