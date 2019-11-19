import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/home/home.service';
@Component({
  selector: 'app-uploaddownloadfile',
  templateUrl: './uploaddownloadfile.component.html',
  styleUrls: ['./uploaddownloadfile.component.css']
})
export class UploaddownloadfileComponent implements OnInit {
  fileToUpload: File = null;
  constructor( private _HomeService: HomeService,) { }

  ngOnInit() {
  }
  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
}

uploadFileToActivity() {
  this._HomeService.postFile(this.fileToUpload).subscribe(data => {
   console.log(data)
    }, error => {
      console.log(error);
    });
}
download() {
  this._HomeService.downloadFile().subscribe(response => {
    let blob:any = new Blob([response.blob()], { type: 'text/json; charset=utf-8' });
    const url= window.URL.createObjectURL(blob);
    window.open(url);
    window.location.href = response.url;

  }), error => console.log('Error downloading the file'),
               () => console.info('File downloaded successfully');
}
}
