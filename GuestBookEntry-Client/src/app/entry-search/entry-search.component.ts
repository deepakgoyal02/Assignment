import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { EntryService } from '../shared/entry/entry.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-entry-search',
  templateUrl: './entry-search.component.html',
  styleUrls: ['./entry-search.component.css']
})

export class EntrySearchComponent implements OnInit {

  sub: Subscription;
  entry: any = {};
  entries: Array<any>;
  highlightedRows = [];
  displayedColumns = ['id', 'name', 'comment', 'lastUpdate'];

  constructor(private route: ActivatedRoute,
    private router: Router,
    private entryService: EntryService
  ) {
  }

  ngOnInit() {

  }

  searchEntry(name: string) {
    this.entryService.getByName(name).subscribe(data => {
      this.entries = data;
    });
  }
}
