
class Solution {
public:
    struct Node {
        long long score = 0;
        vector<int> idxs;
    };
    
    int n;
    vector<int> nextIdx;
    vector<vector<Node>> t;
    vector<vector<bool>> visited;

    int findNext(const vector<vector<int>>& intervals, int r) {
        int lo = 0, hi = n - 1;
        int result = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (intervals[mid][0] > r) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }

    Node Solve(const vector<vector<int>>& intervals, int k, int i) {
        if (k == 0 || i >= n) {
            return {0, {}};
        }

        if (visited[i][k]) {
            return t[i][k];
        }

        Node Skip = Solve(intervals, k, i + 1);

        int wt = intervals[i][2];
        int idx = intervals[i][3];
        int j = nextIdx[i];

        Node temp = Solve(intervals, k - 1, j);
        
        Node Take;
        Take.score = wt + temp.score;
        Take.idxs = temp.idxs;
        Take.idxs.push_back(idx);
        sort(Take.idxs.begin(), Take.idxs.end());

        Node result;
        if (Skip.score > Take.score) {
            result = Skip;
        } else if (Take.score > Skip.score) {
            result = Take;
        } else {
            result = (Skip.idxs < Take.idxs) ? Skip : Take;
        }

        visited[i][k] = true;
        return t[i][k] = result;
    }

    vector<int> maximumWeight(vector<vector<int>>& intervals) {
        n = intervals.size();

        for (int i = 0; i < n; i++) {
            intervals[i].push_back(i);
        }

        sort(intervals.begin(), intervals.end());

        nextIdx.resize(n);
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            nextIdx[i] = findNext(intervals, end);
        }

        int K = 4;
        t.assign(n + 1, vector<Node>(K + 1));
        visited.assign(n + 1, vector<bool>(K + 1, false));

        return Solve(intervals, K, 0).idxs;
    }
};