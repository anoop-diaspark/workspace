import { Component, OnInit } from '@angular/core';
import { HomeService } from '../home/home.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  transaction: {}
  checkboxmark;
  dropdownList = [];
  selectedItems: any;
  dropdownSettings = {};
  login: FormGroup;
  data: any[] = [
  ]
  bol: boolean = false;
  name: string;


  groupValue: string[] = []

  newArray = []
  constructor(private formBuilder: FormBuilder, private _HomeService: HomeService) {
  }

  shareCheckedList(item: any[]) {
  }
  shareIndividualCheckedList(item: {}) {
  }


  ngOnInit() {
    this.dropdownList = [
      { "id": 1, "itemName": "India", countryName: "India" },
      { "id": 2, "itemName": "USA", countryName: "USA" },
      { "id": 3, "itemName": "Mexico", countryName: "Mexico" },
      { "id": 4, "itemName": "London", countryName: "london" },
      { "id": 5, "itemName": "Germany", countryName: "Germany" },
    ];
    this.selectedItems = [

    ];
    this.dropdownSettings = {
      singleSelection: false,
      text: "Select Countries",
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableSearchFilter: true,
      classes: "myclass custom-class"
    };
    this.login = this.formBuilder.group({
      countryName1: ['',],
    })
    this._HomeService.getall().subscribe(res => {
      this.data = res;
      console.log(res);
      this.bol = true;
    },

    );


  }
  onItemSelect(item: any) {
    let result = this.selectedItems.map(({ itemName }) => itemName)
    this.changeGroup1(result);

  }
  OnItemDeSelect(item: any) {
    let result = this.selectedItems.map(({ itemName }) => itemName)
    this.changeGroup1(result);

  }
  onSelectAll(items: any) {
    let result = this.selectedItems.map(({ itemName }) => itemName)
    this.changeGroup1(result);

  }
  onDeSelectAll(items: any) {
    let result = this.selectedItems.map(({ itemName }) => itemName)
    this.changeGroup1(result);

  }

  changeGroup1(result) {

    const index = this.groupValue.indexOf(result);

    if (index > -1) {
      this.groupValue.splice(index, 1);
    } else {
      this.groupValue.push(result);
    }
    this.transform1(this.data, 'countryName', result)
    if (result.length == 0) {
      this.transform1(this.data, '', result)
    }
  }
  transform1(items: any[], field: string, value: string[]): any[] {
    if (!items) {
      return [];
    }
    if (!field || !value || value.length <= 0) {
      return items;
    }
    
    this.newArray = items.filter(singleItem => {
      return (singleItem != null && singleItem[field] != null && singleItem[field] != undefined && value.indexOf(singleItem[field]) >= 0);
    });
    
  }
}
