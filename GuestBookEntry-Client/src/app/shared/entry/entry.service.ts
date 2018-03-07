import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class EntryService {
  public API = '//localhost:8080';
  public ENTRY_ADD_API = this.API + '/entry-add';
  public ENTRY_UPDATE_API = this.API + '/entry-update';
  public ENTRY_DELETE_API = this.API + '/entry-delete';
  public ENTRY_GET_API = this.API + '/entry-get';
  public ENTRY_SEARCH_API = this.API + '/entries-search';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/all-entries');
  }

  get(id: string): Observable<any> {
    return this.http.get(this.ENTRY_GET_API + '/' + id);
  }

  getByName(name: string): Observable<any> {
    return this.http.get(this.ENTRY_SEARCH_API + '/' + name);
  }

  save(entry: any): Observable<any> {
    let result: Observable<Object>;
    console.log("1");
      console.log(entry);
    if (entry['href']) {
      
      console.log("2");
      entry['href']='';
      result = this.http.put(this.ENTRY_UPDATE_API, entry);
    } else {
      result = this.http.post(this.ENTRY_ADD_API, entry);
    }
    return result;
  }

  remove(id: string) {
    return this.http.delete(this.ENTRY_DELETE_API + '/' + id);
  }
}