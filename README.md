# allegro-nice-api
Flexible and easy to use java api for allegro service focused on trading operation on allegro platform.

## Initialize object
```java
int countryId = 1;
Configuration conf = new Configuration(countryId);
Credentials cred = new Credentials("username", "password", "key");

IAllegroNiceApi allegro = AllegroNiceApi.Builder()
                            .conf(conf)
                            .cred(cred)
                            .build();
```

## Login
```java
allegro.login();
```

## Get system messages
```java
List<AllegroMessage> msgs = allegro.getAllMessages(LocalDateTime.now().minusDays(30));
```

## Subscribe to journal
You can subscribe to user's journal using ```api.getSiteJournal(startingPoint)```.
This method returns [Observable](http://reactivex.io/documentation/observable.html) object.
```java
long startingPoint = 0;
api.getSiteJournal(startingPoint)
    .subscribe(System.out::println);
```

To handle errors and on complete use:
```java
api.getSiteJournal(startingPoint)
    .subscribe(
        j -> System.out.println("on next: " + j),
        t -> System.out.println("on error: " + t),
        () -> System.out.println("on complete")
    );
```
Read more on [RxJava](https://github.com/ReactiveX/RxJava).

### _... work in progress_

License
=======

    Copyright 2013 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
