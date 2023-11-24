import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from 'src/app/models/employee';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{
  employees: Employee[] = [];
  dataSource: any = [];
  displayColumn: string[] = ['id', "name", 'age', 'position_id']
  constructor(private employeeService: EmployeeService){}
  ngOnInit(): void {
    this.employeeService.getEmployee().subscribe(data=>{
      this.employees = data;
      this.dataSource = data
    });
  }

}
