package main

import (
	"math"
	"strings"
	"time"

	"github.com/PtrTeixeira/cookbook/strava/api"
)

// GetPunchcard turns a list of activities into an activity count by weekday and time
func GetPunchcard(activites []api.AthleteActivity) map[string]map[int]int {
	monday := make(map[int]int)
	tuesday := make(map[int]int)
	wednesday := make(map[int]int)
	thursday := make(map[int]int)
	friday := make(map[int]int)
	saturday := make(map[int]int)
	sunday := make(map[int]int)

	days := make(map[string]map[int]int)
	days["MONDAY"] = monday
	days["TUESDAY"] = tuesday
	days["WEDNESDAY"] = wednesday
	days["THURSDAY"] = thursday
	days["FRIDAY"] = friday
	days["SATURDAY"] = saturday
	days["SUNDAY"] = sunday

	for _, activity := range activites {
		incrementPunchcardCount(activity, days)
	}

	return days
}

// GetDistanceDifference returns the difference between activities and mile boundaries
func GetDistanceDifference(activities []api.AthleteActivity) map[int]int {
	distances := make(map[int]int, 10)
	for _, activity := range activities {
		distanceInMiles := convertMetersToMiles(activity.Distance)
		distanceDifference := getSingleDistanceDifference(distanceInMiles)
		increment(distanceDifference, distances)
	}

	return distances
}

func increment(key int, dest map[int]int) {
	old, _ := dest[key]
	dest[key] = old + 1
}

func getHourFromTime(t time.Time) int {
	return t.Hour()
}

func getWeekdayFromTime(t time.Time) string {
	return strings.ToUpper(t.Weekday().String())
}

func convertMetersToMiles(d float64) float64 {
	return d / 1609.344
}

func getLocalTimeFromActivity(activity api.AthleteActivity) time.Time {
	localTime := activity.StartDateLocal
	asTime, _ := time.Parse(time.RFC3339, localTime)

	return asTime
}

func incrementPunchcardCount(activity api.AthleteActivity, count map[string]map[int]int) {
	activityTime := getLocalTimeFromActivity(activity)
	hour := getHourFromTime(activityTime)
	weekday := getWeekdayFromTime(activityTime)

	increment(hour, count[weekday])
}

func getDistanceDifferences(activityDistances []float64) map[int]int {
	resultMap := make(map[int]int)
	for _, distance := range activityDistances {
		distanceDifference := getSingleDistanceDifference(distance)
		increment(distanceDifference, resultMap)
	}

	return resultMap
}

func getSingleDistanceDifference(activityMileage float64) int {
	result := math.Round(10*activityMileage) - 10*math.Round(activityMileage)
	return int(result)
}
