<template>
  <div>
	<canvas id="myChart" width="400" height="400"></canvas>
  </div>
</template>

<script>
import { Radar } from "vue-chartjs";
export default {
    extends: Radar,
    mounted() {
        const ctx = document.getElementById('myChart').getContext('2d');
        this.renderChart(
            {
                labels: [
                            "WorkoutName",
                            "WorkoutDomain",
                            "WorkoutStructure",
                            "WorkoutWeights",
                            "WorkoutTime",
                            "WorkoutRounds"
                ],
                datasets: [
                    {
                        label: "Workout Goals",
                        backgroundColor: "rgba(179,181,198,0.2)",
                        borderColor: "rgba(179,181,198,1)",
                        pointBackgroundColor: "rgba(179,181,198,1)",
                        pointBorderColor: "#fff",
                        pointHoverBackgroundColor: "#fff",
                        pointHoverBorderColor: "rgba(179,181,198,1)",
                        data: [65, 59, 90, 81, 56, 55, 40]
                    },
                    {
                        label: "Logged Workout Progress",
                        backgroundColor: "rgba(255,99,132,0.2)",
                        borderColor: "rgba(255,99,132,1)",
                        pointBackgroundColor: "rgba(255,99,132,1)",
                        pointBorderColor: "#fff",
                        pointHoverBackgroundColor: "#fff",
                        pointHoverBorderColor: "rgba(255,99,132,1)",
                        data: [28, 48, 40, 19, 96, 27, 100]
                    }
                ]
            },
            {responsive: true, maintainAspectRatio: false}
        );
    }

}
</script>

<style>

</style>