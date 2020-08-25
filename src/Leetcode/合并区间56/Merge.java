package Leetcode.合并区间56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Merge
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/27 下午7:26
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class Merge {
    //把每个区间按照开始端点排序，然后遍历起始点集合，若该起始点在上一个区间内，说明有交集，就要合并两个区间
    //if curr.start <= last.end
    //   merge intervals
    //else:
    //  Insert a new interval
    public int[][] merge(int[][] intervals){
        //返回的结果合集
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return result.toArray(new int[0][]);
        //按每个区间起始点从小到大排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int i = 0;
        while (i < intervals.length){
            //每个区间的左端点
            int left = intervals[i][0];
            //每个区间的右端点
            int right = intervals[i][1];
            //若当前区间的右端点大雨后一个区间的左端点，说明区间有交集，合并
            while(i < intervals.length-1 && right >= intervals[i+1][0]){
                right = Math.max(right,intervals[++i][1]);
            }
            result.add(new int[]{left,right});
            i++;
        }
        return result.toArray(new int[0][]);

    }

}
