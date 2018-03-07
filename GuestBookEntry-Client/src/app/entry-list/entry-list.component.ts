import { Component, OnInit } from '@angular/core';
import { EntryService } from '../shared/entry/entry.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-entry-list',
  templateUrl: './entry-list.component.html',
  styleUrls: ['./entry-list.component.css']
})

export class EntryListComponent implements OnInit {
  entries: Array<any>;
  highlightedRows = [];
  displayedColumns = ['id', 'name', 'comment', 'lastUpdate'];
  

  constructor(private entryService: EntryService,
     private giphyService: GiphyService,
     private route: ActivatedRoute,
    private router: Router) { }

  editEntry(id: string) {
    this.router.navigate(['/entry-edit/'+id]);
  }

  ngOnInit() {
    this.entryService.getAll().subscribe(data => {      
      this.entries = data;
      for (const entry of this.entries) {
        this.giphyService.get(entry.name).subscribe(url => entry.giphyUrl = url);
      }
    });
  }  
}
