<template>
  <div>
      <table>
  <thead>
    <tr>
      <th></th>
      <th>
        <span class="day">12:00</span>
        <span class="short">pushDay</span>

      </th>
      <th>
        <span class="day">1:00</span>  
        <span class="short">PullDay</span>
      </th>
      <th>
        <span class="day">2:00</span>
        <span class="short">Tue</span>
      </th>
      <th>
        <span class="day">3:00</span>
        <span class="short">We</span>
      </th>
      <th>
        <span class="day">4:00</span>
        <span class="short">Thur</span>
      </th>
      <th>
        <span class="day active">5:00</span>
        <span class="short">Fri</span>
      </th>
      <th>
        <span class="day">6:00</span>
        <span class="short">Sat</span>
      </th>
      <th>
        <span class="day">7:00</span>
        <span class="short">Sun</span>
      </th>
    </tr>
  </thead>
  <tbody>
       <tr>
      <td class="day" rowspan="4"><span>Monday</span></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td> 
      <td></td>
      <td></td>
    </tr>
    <tr>
  
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
  <tbody>
       <tr>
      <td class="day" rowspan="4"><span>Tuesday</span></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td>
      <td></td> 
      <td></td>
      <td></td>
    </tr>
    <tr>
    
      <td></td>
      <td></td> 
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody> 
  <tbody>
       <tr>
      <td class="day" rowspan="4"><span>Wednesay</span></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td> 
      <td></td>
      <td></td>
    </tr>
    <tr>
  
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
  <tbody>
       <tr>
      <td class="day" rowspan="4"><span>Thursday</span></td>
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td> 
      <td></td>
      <td></td>
    </tr>
    <tr>
  
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
  <tbody>
       <tr>
      <td class="day" rowspan="4"><span>Friday</span></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td> 
       <td></td>
      <td></td>
      <td></td>
    </tr>
    <tr>
  
      <td></td>
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
  <tbody>
       <tr>
      <td class="day" rowspan="4"><span>Saturday</span></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td>
      <td></td> 
      <td></td>
      <td></td>
    </tr>
    <tr>
  
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
  <tbody>
       <tr>
      <td class="day" rowspan="4"><span>Sunday</span></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td> 
      <td></td>
      <td></td>
    </tr>
    <tr>
  
      <td></td>
      <td></td>
      <td></td>
       <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
  </tbody>
  
    
  </table>
  </div>
</template>

<script>
export default {
    name: 'calendar',
props: [ 'classItem' ],
computed: {
    getClassList() {
        return this.$store.state.classList;
    }
},
}
</script>

<style>
table {
  font-family: sans-serif;
  width: 100%;
  border-spacing: 0;
  border-collapse: separate;
  table-layout: fixed;
  margin-bottom: 50px;
}
table thead tr th {
  background: #626E7E;
  color: #d1d5db;
  padding: 0.5em;
  overflow: hidden;
}
table thead tr th:first-child {
  border-radius: 3px 0 0 0;
}
table thead tr th:last-child {
  border-radius: 0 3px  0 0;
}
table thead tr th .day {
  display: block;
  font-size: 1.2em;
  border-radius: 50%;
  width: 30px;
  height: 30px;
  margin: 0 auto 5px;
  padding: 5px;
  line-height: 1.8;
}
table thead tr th .day.active {
  background: #d1d5db;
  color: #626E7E;
}
table thead tr th .short {
  display: none;
}
table thead tr th i {
  vertical-align: middle;
  font-size: 2em;
}
table tbody tr {
  background: #d1d5db;
}
table tbody tr:nth-child(odd) {
  background: #c8cdd4;
}
table tbody tr:nth-child(4n+0) td {
  border-bottom: 1px solid #626E7E;
}
table tbody tr td {
  text-align: center;
  vertical-align: middle;
  border-left: 1px solid #626E7E;
  position: relative;
  height: 32px;
  cursor: pointer;
}
table tbody tr td:last-child {
  border-right: 1px solid #626E7E;
}
table tbody tr td.hour {
  font-size: 2em;
  padding: 0;
  color: #626E7E;
  background: #fff;
  border-bottom: 1px solid #626E7E;
  border-collapse: separate;
  min-width: 100px;
  cursor: default;
}
table tbody tr td.hour span {
  display: block;
}
</style>