<h2>340. Longest Substring with At Most K Distinct Characters</h2><h3>Medium</h3><hr><div><p>Given a string <code>s</code> and an integer <code>k</code>, return <em>the length of the longest substring of</em> <code>s</code> <em>that contains at most</em> <code>k</code> <em><strong>distinct</strong> characters</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: s = &quot;eceba&quot;, k = 2
Output: 3
Explanation: The substring is &quot;ece&quot; with length 3." data-snippet-id="ext.82855b6d120abcf186250d18ed60e4f9" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> s = "eceba", k = 2
<strong>Output:</strong> 3
<strong>Explanation:</strong> The substring is "ece" with length 3.</pre>

<p><strong>Example 2:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: s = &quot;aa&quot;, k = 1
Output: 2
Explanation: The substring is &quot;aa&quot; with length 2.
" data-snippet-id="ext.6a182538661b13b9ab51da53c24a8385" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> s = "aa", k = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The substring is "aa" with length 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= k &lt;= 50</code></li>
</ul>
</div>