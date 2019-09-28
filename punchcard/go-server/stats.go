package main

import (
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
