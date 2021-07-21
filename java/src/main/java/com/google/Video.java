package com.google;

import java.util.Collections;
import java.util.List;

/** A class used to represent a video. */
class Video {

  private final String title;
  private final String videoId;
  private final List<String> tags;

  Video(String title, String videoId, List<String> tags) {
    this.title = title;
    this.videoId = videoId;
    this.tags = Collections.unmodifiableList(tags);
  }

  /** Returns the title of the video. */
  String getTitle() {
    return title;
  }

  /** Returns the video id of the video. */
  String getVideoId() {
    return videoId;
  }

  /** Returns a readonly collection of the tags of the video. */
  List<String> getTags() {
    return tags;
  }
  public String stringTags(){

    String temp="[";
    for(int i=0;i<this.tags.size();i++){
      if (i>=1){
        temp=temp+" "+this.tags.get(i);
      }
      else{
        temp=temp+this.tags.get(i);
      }
    }
    temp=temp+"]";
    return temp;
  }
  @Override
  public boolean equals(Object object){
      return (this==object);

  }
  public String showContent(){
    String temp= this.getTitle()+" ("+this.getVideoId()+") "+this.stringTags();
    return temp;
  }

}
