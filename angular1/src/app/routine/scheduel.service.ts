import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ScheduelService {

  _url = 'http://192.168.96.222:8080/match'
  id: number;
 
  constructor(private http: HttpClient) { }
  form: FormGroup = new FormGroup({
    id: new FormControl("", ),
    countryName: new FormControl("", ),
    matchDate: new FormControl("", ),
    matchType: new FormControl("", ),
  
  });


  initializeFormGroup() {
  
    this.form.setValue({
     id:"",
      countryName: "fghjk",
      matchDate: "",
      matchType: "",
     
    });
  }
  forid(row){
    this.id = row.id
    console.log(this.id)
    return row.id;
    }
  populateForm(employee) {
   this.form.setValue(employee)
   console.log(this.form);
      
      }
      adddetail(reg) {
        return this.http.post<String>(this._url, reg);
      }

      editdetail(id,countryName,matchDate,matchType) {
        let body
        console.log(this.id)
        return this.http.put<any>(`http://192.168.96.222:8080/update/${id}?countryName=${countryName}&matchType=${matchType}&matchDate=${matchDate}`,body);
      }

      deleteOneRowData(id: number,pagenumber:number){
        return this.http.delete<any>(`http://192.168.96.222:8080/removerow/${id}?pageNumber=${pagenumber}`)
        }
}
