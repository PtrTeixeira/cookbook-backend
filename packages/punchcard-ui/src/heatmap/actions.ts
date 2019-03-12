export interface IWeeklyResults {
  "MONDAY"?: IHourlyResults,
  "TUESDAY"?: IHourlyResults,
  "WEDNESDAY"?: IHourlyResults,
  "THURSDAY"?: IHourlyResults,
  "FRIDAY"?: IHourlyResults,
  "SATURDAY"?: IHourlyResults,
  "SUNDAY"?: IHourlyResults;
  [key: string]: IHourlyResults | undefined;
}

export interface IHourlyResults {
  "0"?: number,
  "1"?: number,
  "2"?: number,
  "3"?: number,
  "4"?: number,
  "5"?: number,
  "6"?: number,
  "7"?: number,
  "8"?: number,
  "9"?: number,
  "10"?: number,
  "11"?: number,
  "12"?: number,
  "13"?: number,
  "14"?: number,
  "15"?: number,
  "16"?: number,
  "17"?: number,
  "18"?: number,
  "19"?: number,
  "20"?: number,
  "21"?: number,
  "22"?: number,
  "23"?: number;
  [key: string]: number | undefined;
}

function buildHourlyGrid(data: IHourlyResults): number[] {
  return new Array(24)
    .fill(0)
    .map((e, index) => data[`${index}`])
    .map(element => {
      if (element === null || element === undefined) {
        return 0
      } else {
        return element
      }
    });
}

function buildHourlyGridSafe(data: IHourlyResults | undefined | null): number[] {
  if (data === undefined || data === null) {
    return new Array(24).fill(0)
  } else {
    return buildHourlyGrid(data)
  }
}

function rotate(data: number[][]): number[][] {
  return new Array(data[0].length).fill(0)
    .map((e, outerIndex) => {
      return new Array(data.length).fill(0)
        .map((_, innerIndex) => data[innerIndex][outerIndex])
    });
}

export function buildWeeklyGrid(data: IWeeklyResults): number[][] {
  const grid = ([
    "MONDAY",
    "TUESDAY",
    "WEDNESDAY",
    "THURSDAY",
    "FRIDAY",
    "SATURDAY",
    "SUNDAY"
  ]).map(weekday => buildHourlyGridSafe(data[weekday]));

  return rotate(grid)
}
