import { Injectable } from '@angular/core';


import { Observable,Subject, BehaviorSubject } from 'rxjs';



@Injectable(
  
)
export class DataService {

public subject = new BehaviorSubject<any>(null);

sendMessage(message: string) {
this.subject.next({ text: message });
}


sendMessage1(message: number) {
    this.subject.next({ text: message });
    }
clearMessages() {
this.subject.next(null);
}

getMessage(): Observable<any> {
return this.subject.asObservable();
}

constructor() { }


}