<h2><a href="https://leetcode.com/problems/longest-valid-parentheses/">32. Longest Valid Parentheses</a></h2><h3>Hard</h3><hr><div><p>Given a string containing just the characters <code>'('</code> and <code>')'</code>, find the length of the longest valid (well-formed) parentheses substring.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: s = &quot;(()&quot;
Output: 2
Explanation: The longest valid parentheses substring is &quot;()&quot;.
" data-snippet-id="ext.aa067a43cf41e9b5eab75eaf5ff978de" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> s = "(()"
<strong>Output:</strong> 2
<strong>Explanation:</strong> The longest valid parentheses substring is "()".
</pre>

<p><strong>Example 2:</strong></p>

<div class="top-box hide"><div class="alert-info"></div></div><pre data-original-code="Input: s = &quot;)()())&quot;
Output: 4
Explanation: The longest valid parentheses substring is &quot;()()&quot;.
" data-snippet-id="ext.666f2e1fefca534663c343466a6cf4b7" data-snippet-saved="false" data-codota-status="done"><strong>Input:</strong> s = ")()())"
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest valid parentheses substring is "()()".
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> s = ""
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> is <code>'('</code>, or <code>')'</code>.</li>
</ul>
</div>