# CraglistCrawler

## How do I crawl
1. Use jsoup to grasp the content of the web-page
2. Notice that the each element we want is stored under a list with tag "li.result-row"
3. For each element, grasp the information we want based ont tags:
   title -- a.result-title
   price -- a.result-price
   url -- a.result-image with href tag
   hood -- span.result-hood

The external jar file I am using is jsoup-1.11.3.jar, which helps me do the content crawling.
