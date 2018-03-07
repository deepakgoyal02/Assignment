import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { EntryService } from '../shared/entry/entry.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-entry-edit',
  templateUrl: './entry-edit.component.html',
  styleUrls: ['./entry-edit.component.css']
})
export class EntryEditComponent implements OnInit, OnDestroy {
  entry: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private entryService: EntryService,
              private giphyService: GiphyService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.entryService.get(id).subscribe((entry: any) => {
          if (entry) {
            this.entry = entry;
            this.entry.href = "href";
            this.giphyService.get(entry.name).subscribe(url => entry.giphyUrl = url);
          } else {
            console.log(`Entry with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
     });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/entry-list']);
  }

  save(form: NgForm) {
    this.entryService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error))
  }

  remove(href) {
    this.entryService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error))
  }
}
