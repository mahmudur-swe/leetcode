<h2><a href="https://leetcode.com/problems/dot-product-of-two-sparse-vectors/">1570. Dot Product of Two Sparse Vectors</a></h2><h3>Medium</h3><hr><div><p>Given two sparse vectors, compute their dot product.</p>

<p>Implement class <code>SparseVector</code>:</p>

<ul data-indent="0" data-stringify-type="unordered-list">
	<li><code>SparseVector(nums)</code>&nbsp;Initializes the object with the vector <code>nums</code></li>
	<li><code>dotProduct(vec)</code>&nbsp;Compute the dot product between the instance of <em>SparseVector</em> and <code>vec</code></li>
</ul>

<p>A <strong>sparse vector</strong> is a vector that has mostly zero values, you should store the sparse vector&nbsp;<strong>efficiently </strong>and compute the dot product between two <em>SparseVector</em>.</p>

<p><strong>Follow up:&nbsp;</strong>What if only one of the vectors is sparse?</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
" data-snippet-id="ext.9e373a9e2c201871c98203795fe6c55b" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
<strong>Output:</strong> 8
<strong>Explanation:</strong> v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
</pre>

<p><strong>Example 2:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
" data-snippet-id="ext.9145b68d52ec380ac458f56194bbf12b" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
</pre>

<p><strong>Example 3:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6
" data-snippet-id="ext.3a8d44699711a8df1548c9bf7d3eb1e8" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
<strong>Output:</strong> 6
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums1.length == nums2.length</code></li>
	<li><code>1 &lt;= n &lt;= 10^5</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i]&nbsp;&lt;= 100</code></li>
</ul>
</div>