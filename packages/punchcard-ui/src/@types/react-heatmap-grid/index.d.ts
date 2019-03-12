declare module 'react-heatmap-grid' {
  export interface HeatmapProps {
    xLabels: string[];
    yLabels: string[];
    data: number[][];
    background?: string;
    height?: number;
    squares?: boolean;
    xLabelWidth?: number;
    yLabelWidth?: number;
    yLabelTextAlign?: string;
    xLabelsLocation?: string;
    xLabelsVisibility?: boolean[];
    unit?: string;
  }

  declare const HeatMap: React.SFC<HeatmapProps>;
  export default HeatMap;
}
