import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { HomeService } from '../home/home.service';
import { Customer } from '../home/home.service';
import { MatPaginator } from "@angular/material/paginator";
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { SelectionModel } from '@angular/cdk/collections';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { ScheduelService } from './scheduel.service';
import { ScehduelComponent } from './scehduel/scehduel.component';
import { ScheduleeditComponent } from './scheduleedit/scheduleedit.component';
import { DataService } from './dataservice.service';
import { DataSource } from '@angular/cdk/collections';
import { DeletedialogComponent } from './deletedialog/deletedialog.component';
import { Router } from '@angular/router';


@Component({
  selector: 'app-routine',
  templateUrl: './routine.component.html',
  styleUrls: ['./routine.component.css'],
  
})


export class RoutineComponent implements OnInit {
  checkboxmark;
  dropdownList = [];
  dropdownList2 = [];
  selectedItems1 = [];
  mydata: any
  selectedItems2 = [];
  groupValue: string[] = []
  groupValue1: string[] = []
  dropdownSettings1 = {

  };
  pagenumber = 1
  res2
  res1
  count = 0
  flag = false
  newArray = []
  newArray1 = []
  dropdownSettings2 = {

  };
  list1: any[];
  list2: any[];
  displayedColumns: string[] = ["id", 'countryName', 'matchDate', 'matchType', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  dataSource2 = new MatTableDataSource<Customer>(this.list2);
  selection = new SelectionModel<Customer>(true, []);
  searchKey: string;
  dataSource1 = new MatTableDataSource<Customer>(this.list1);
  constructor(
    private _HomeService: HomeService, private dialog: MatDialog,private scheduelService : ScheduelService,private dataService : DataService,private changeDetectorRefs: ChangeDetectorRef,private router : Router) { }

  ngOnInit() {

    this.dropdownList = [
      { "id": 1, "itemName": "India", countryName: "India" },
      { "id": 2, "itemName": "USA", countryName: "USA" },
      { "id": 3, "itemName": "Germany", countryName: "Germany" },
      { "id": 4, "itemName": "Mexico", countryName: "England" },
      { "id": 5, "itemName": "Sri Lanka", countryName: "Sri Lanka" },
    ];

    this.dropdownList2 = [
      { "id": 1, "itemName": "t20" },
      { "id": 2, "itemName": "odi" },
      { "id": 3, "itemName": "test" }
    ];
    this.dropdownSettings1 = {
      singleSelection: false,
      text: "Select Country",
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableSearchFilter: true,
      classes: "myclass custom-class"
    };
    this.dropdownSettings2 = {
      text: "Select Format",
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableSearchFilter: true,
      classes: "myclass custom-class"
    };

    this._HomeService.getallmatchdetails(this.pagenumber).subscribe(res => {
      this.mydata = res;
      console.log(res);
    },

    );
  }
  logout(){
    this._HomeService.logout();
    this.router.navigate(["/auth"]);
  }
  onCreate()
  {
    this.scheduelService.initializeFormGroup();
    const dialogConfig = new MatDialogConfig();
      dialogConfig.disableClose = true;
      dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(ScehduelComponent, dialogConfig).afterClosed().subscribe(() => {
      this.getdatabypage(this.pagenumber)
    })
    
  }
  onEdit(row){
    console.log(row);
    this.scheduelService.populateForm(row);
    this.scheduelService.forid(row);
    this.dataService.sendMessage(row.id);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(ScheduleeditComponent,dialogConfig).afterClosed().subscribe(() => {
      this.getdatabypage(this.pagenumber)
    })
  }
  getServerData(event) {
    console.log(event);
    this.pagenumber = event.pageSize
    this._HomeService.getallmatchdetails(event.pageSize).subscribe(res => {
      this.mydata = res;
      console.log(res);
    },

    );
  }
  getdatabypage(pagesize){
    this._HomeService.getallmatchdetails(pagesize).subscribe(res => {
      this.mydata = res;
      this.newArray = res;
      this.list1 = res
      console.log(res,"called after closed");
      this.changeGroup2(this.res1,this.res2);
    },

    );
  }
  private refreshTable() {
    // Refreshing table using paginator
    // Thanks yeager-j for tips
    // https://github.com/marinantonio/angular-mat-table-crud/issues/12
    this.paginator._changePageSize(this.paginator.pageSize);
  }


  delete(row) {
    this.scheduelService.populateForm(row);
    this.dataService.sendMessage1(this.pagenumber);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(DeletedialogComponent,dialogConfig).afterClosed().subscribe(() => {
      this.getdatabypage(this.pagenumber)
    })
  }
  products ={
    countryName:[],
    matchType:[]
  }
  onItemSelect1(item: any) {
    let result1 = this.selectedItems1.map(({ itemName }) => itemName)
    let result2 = this.selectedItems2.map(({ itemName }) => itemName)
    this.res1 = result1
    this.res2 = result2
    this.products.countryName = result1
    this.products.matchType = result2
    this._HomeService.getallmatchdetails1(this.pagenumber,this.products).subscribe(res => {
    
      console.log("new",res);
    },

    );
    this.changeGroup2(result1, result2);
    console.log("res1", result1)


  }
  onItemSelect2(item: any) {
    let result2 = this.selectedItems2.map(({ itemName }) => itemName)
    // this.changeGroup1(result2);

  }
  OnItemDeSelect1(item: any) {
    let result1 = this.selectedItems1.map(({ itemName }) => itemName)
    let result2 = this.selectedItems1.map(({ itemName }) => itemName)
    this.changeGroup2(result1, result2);


  }
  OnItemDeSelect2(item: any) {
    let result1 = this.selectedItems1.map(({ itemName }) => itemName)
    let result2 = this.selectedItems2.map(({ itemName }) => itemName)
    this.changeGroup2(result1, result2);

  }
  onSelectAll1(items: any) {
    let result1 = this.selectedItems1.map(({ itemName }) => itemName)


  }
  onDeSelectAll2(items: any) {
    let result1 = this.selectedItems1.map(({ itemName }) => itemName)
    let result2 = this.selectedItems2.map(({ itemName }) => itemName)
    this.changeGroup2(result1, result2);

  }

  changeGroup2(result1, result2) {

    const index = this.groupValue.indexOf(result1);
    const index1 = this.groupValue.indexOf(result2);

    if (index > -1) {
      this.groupValue.splice(index, 1);
    } else {
      this.groupValue.push(result1);
    }

    if (index1 > -1) {
      this.groupValue1.splice(index1, 1);
    } else {
      this.groupValue1.push(result2);
    }


    if (result1.length > 0 && result2.length == 0) { this.transform2(this.mydata, 'countryName', result1) }
    else if (result1.length == 0 && result2.length > 0) {
      this.transform2(this.mydata, 'matchType', result2)
    }
    else {
      this.flag = true
      this.transform2(this.mydata, 'matchType', result2)

      console.log(this.flag)
    }
    if (result1.length == 0) {
      this.transform2(this.mydata, '', result1)
    }


    if (result2.length == 0) {
      this.transform2(this.mydata, '', result2)
    }
  }
  transform2(items: any[], field: string, value: string[]): any[] {
    if (!items) {
      return [];
    }
    if (!field || !value || value.length <= 0) {
      return items;
    }
    if (this.flag) {
      this.count = this.count + 1
      console.log("new", this.flag)
      console.log("newarr", this.newArray, "value", value)
      if (this.count > 1) {
        this.newArray = items.filter(singleItem => {
          return (this.res1.indexOf(singleItem["countryName"]) >= 0);
        });
        console.log("newarr", this.newArray, "value", value)
        this.transform3(this.newArray, 'matchType', value)
      }
      else {
        this.transform3(this.newArray, 'matchType', value)
      }
      //this.flag =false;
    }
    else {
      this.newArray = items.filter(singleItem => {
        return (singleItem != null && singleItem[field] != null && singleItem[field] != undefined && value.indexOf(singleItem[field]) >= 0);
      });
    }

    console.log('kbkbk', this.newArray)
    this.list1 = this.newArray;
    this.dataSource1 = new MatTableDataSource(this.list1);
    this.dataSource1.paginator = this.paginator;
    console.log(this.dataSource1)

    this.dataSource1.sort = this.sort;
    this.changeDetectorRefs.detectChanges();
  }

  transform3(items: any[], field: string, value: string[]): any[] {
    console.log("item", items, "field", field, "value", value)
    if (!items) {
      return [];
    }
    if (!field || !value || value.length <= 0) {
      return items;
    }

    this.newArray1 = items.filter(singleItem => {
      return (singleItem != null && singleItem[field] != null && singleItem[field] != undefined && value.indexOf(singleItem[field]) >= 0);
    });

    console.log('kbk', this.newArray1)
    this.list2 = this.newArray1;
    this.dataSource2 = new MatTableDataSource(this.list2);
    this.dataSource2.paginator = this.paginator;
    this.dataSource2.sort = this.sort;
    this.changeDetectorRefs.detectChanges();
  }
}
