```
D:\BDA\nosql>mongosh "mongodb+srv://morpheus.wwglz7i.mongodb.net/" --apiVersion 1 --username azz
Enter password: ***********
Current Mongosh Log ID: 69806f41c6273d8fc61e2620
Connecting to:          mongodb+srv://<credentials>@morpheus.wwglz7i.mongodb.net/?appName=mongosh+2.5.10
Using MongoDB:          8.0.18 (API Version 1)
Using Mongosh:          2.5.10
mongosh 2.6.0 is available for download: https://www.mongodb.com/try/download/shell

For mongosh info see: https://www.mongodb.com/docs/mongodb-shell/

Atlas atlas-cum04g-shard-0 [primary] test> show dbs
Items          40.00 KiB
amazon_rides  120.00 KiB
sample_mflix  104.93 MiB
admin         360.00 KiB
local          67.70 GiB
Atlas atlas-cum04g-shard-0 [primary] test> create database social_media
Uncaught:
SyntaxError: Missing semicolon. (1:6)

> 1 | create database social_media
    |       ^
  2 |

Atlas atlas-cum04g-shard-0 [primary] test> use social_media
switched to db social_media
Atlas atlas-cum04g-shard-0 [primary] social_media> db.createCollection("social_media_posts")
{ ok: 1 }
Atlas atlas-cum04g-shard-0 [primary] social_media> show collections
social_media_posts
Atlas atlas-cum04g-shard-0 [primary] social_media> db
social_media
Atlas atlas-cum04g-shard-0 [primary] social_media> db.metrics.insertMany([
...   { shares: 50, comments: 10, pageVisits: 300, likes: 15 },
...   { shares: 75, comments: 25, pageVisits: 540, likes: 30 },
...   { shares: 200, comments: 80, pageVisits: 1500, likes: 120 }
... ])
...
{
  acknowledged: true,
  insertedIds: {
    '0': ObjectId('69807091c6273d8fc61e2621'),
    '1': ObjectId('69807091c6273d8fc61e2622'),
    '2': ObjectId('69807091c6273d8fc61e2623')
  }
}
Atlas atlas-cum04g-shard-0 [primary] social_media> show collections
metrics
social_media_posts
Atlas atlas-cum04g-shard-0 [primary] social_media> db.metrics.drop()
true
Atlas atlas-cum04g-shard-0 [primary] social_media> show collections
social_media_posts
Atlas atlas-cum04g-shard-0 [primary] social_media> db.social_media_posts.insertMany([
...   { shares: 50, comments: 10, pageVisits: 300, likes: 15 },
...   { shares: 75, comments: 25, pageVisits: 540, likes: 30 },
...   { shares: 200, comments: 80, pageVisits: 1500, likes: 120 }
... ])
...
{
  acknowledged: true,
  insertedIds: {
    '0': ObjectId('698070c8c6273d8fc61e2624'),
    '1': ObjectId('698070c8c6273d8fc61e2625'),
    '2': ObjectId('698070c8c6273d8fc61e2626')
  }
}
Atlas atlas-cum04g-shard-0 [primary] social_media> db.social_media_posts.find().pretty()
[
  {
    _id: ObjectId('698070c8c6273d8fc61e2624'),
    shares: 50,
    comments: 10,
    pageVisits: 300,
    likes: 15
  },
  {
    _id: ObjectId('698070c8c6273d8fc61e2625'),
    shares: 75,
    comments: 25,
    pageVisits: 540,
    likes: 30
  },
  {
    _id: ObjectId('698070c8c6273d8fc61e2626'),
    shares: 200,
    comments: 80,
    pageVisits: 1500,
    likes: 120
  }
]
Atlas atlas-cum04g-shard-0 [primary] social_media> db.social_media_posts.find({ likes: { $gte: 30 } }).pretty()
[
  {
    _id: ObjectId('698070c8c6273d8fc61e2625'),
    shares: 75,
    comments: 25,
    pageVisits: 540,
    likes: 30
  },
  {
    _id: ObjectId('698070c8c6273d8fc61e2626'),
    shares: 200,
    comments: 80,
    pageVisits: 1500,
    likes: 120
  }
]
Atlas atlas-cum04g-shard-0 [primary] social_media> db.social_media_posts.updateOne(
...   { shares: 50 },
...   { $inc: { likes: 10 } }
... )
...
{
  acknowledged: true,
  insertedId: null,
  matchedCount: 1,
  modifiedCount: 1,
  upsertedCount: 0
}
Atlas atlas-cum04g-shard-0 [primary] social_media> db.social_media_posts.countDocuments()
3
Atlas atlas-cum04g-shard-0 [primary] social_media> db.metrics.countDocuments()
0
Atlas atlas-cum04g-shard-0 [primary] social_media>
```
