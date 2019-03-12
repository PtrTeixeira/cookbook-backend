declare module 'react-heatmap-grid' {
  export interface HeatmapProps {
    xLabels: string[];
    yLabels: string[];
    data: number[][];
  }

  declare const HeatMap: React.SFC<HeatmapProps>;
  export default HeatMap;
}
