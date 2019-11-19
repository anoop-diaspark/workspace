import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { HomeComponent } from '../home/home.component';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class Customer {
  countyName: string
  matchType: string
  matchDate: string
}
@Injectable({
  providedIn: 'root'
})
export class HomeService {
  _url = 'http://192.168.96.222:8080/country'
  _urls = 'http://192.168.96.222:8080/fetch/alldata';
  //get list of match detail ---
  _url3 = "http://192.168.96.222:8080/fetch/allmatchdata?pageNumber=4"
  constructor(private http: HttpClient) { }

  registeration(reg: HomeComponent) {
    return this.http.post<any>(this._url, reg);
  }
  countrylist1(acno: String) {
    // return this.http.get("http://192.168.96.222:8080/fetch?countryName="+`${acno}`+"");
    return this.http.get(`http://192.168.96.222:8080/fetch?countryName=${acno}`)
  }
  countrylist2(acno: String, acno1: String) {
    return this.http.get(`http://192.168.96.222:8080/fetch/two?countryName=${acno}&countryName1=${acno1}`)
  }

  countrylist3(acno: String, acno1: String, acno2: String) {
    return this.http.get(`http://192.168.96.222:8080/fetch/three?countryName=${acno}&countryName1=${acno1}&countryName2=${acno2}`)
  }

  countrylist4(acno: String, acno1: String, acno2: String, acno3: String) {
    return this.http.get(`http://192.168.96.222:8080/fetch/four?countryName=${acno}&countryName1=${acno1}&countryName2=${acno2}&countryName3=${acno3}`)
  }
  getall() {
    // return this.http.get("http://192.168.96.222:8080/fetch?countryName="+`${acno}`+"");
    return this.http.get<any>(this._urls)
  }
  
  getallmatchdetails(acno: number) {
    // return this.http.get("http://192.168.96.222:8080/fetch?countryName="+`${acno}`+"");
    
    return this.http.get<any>(`http://192.168.96.222:8080/fetch/allmatchdata?pageNumber=${acno}`)
}
getallmatchdetails1(acno: number,products:any) {
  // return this.http.get("http://192.168.96.222:8080/fetch?countryName="+`${acno}`+"");
  
  return this.http.post<any>(`http://192.168.96.222:8080/match?pageNumber=${acno}`,products)
}

authenticate(schedule) {
  return this.http.post<any>('http://localhost:8080/authenticate',schedule).pipe(
   map(
     userData => {
      sessionStorage.setItem('username',schedule);
      let tokenStr= 'Bearer '+userData.token;
      sessionStorage.setItem('token', tokenStr);
      return userData;
     }
   )

  );
}

logout(){
  if(sessionStorage.getItem('token')){
    sessionStorage.removeItem("token")
  }
  
}
postFile(fileToUpload: File) {

  const endpoint = `http://192.168.96.222:8080/uploadFile`;
  const formData: FormData = new FormData();
  formData.append('file', fileToUpload, fileToUpload.name);
  return this.http
    .post<any>(endpoint, formData)
   
}
downloadFile(){		
  return this.http.get<any>('http://localhost:8080/employees/download');
 }
}

