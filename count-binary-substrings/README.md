<h2>696. Count Binary Substrings</h2><h3>Easy</h3><hr><div><p>Give a binary string <code>s</code>, return the number of non-empty substrings that have the same number of <code>0</code>'s and <code>1</code>'s, and all the <code>0</code>'s and all the <code>1</code>'s in these substrings are grouped consecutively.</p>

<p>Substrings that occur multiple times are counted the number of times they occur.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: s = &quot;00110011&quot;
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: &quot;0011&quot;, &quot;01&quot;, &quot;1100&quot;, &quot;10&quot;, &quot;0011&quot;, and &quot;01&quot;.
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, &quot;00110011&quot; is not a valid substring because all the 0's (and 1's) are not grouped together.
" data-snippet-id="ext.9a3d306a0cf64632c8a15c967d8770be" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> s = "00110011"
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
</pre>

<p><strong>Example 2:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: s = &quot;10101&quot;
Output: 4
Explanation: There are 4 substrings: &quot;10&quot;, &quot;01&quot;, &quot;10&quot;, &quot;01&quot; that have equal number of consecutive 1's and 0's.
" data-snippet-id="ext.4aa3440675b53ca7a4abc030045d2755" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> s = "10101"
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
</ul>
</div>