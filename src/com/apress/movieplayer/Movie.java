package com.apress.movieplayer;

import android.database.Cursor;
import android.provider.MediaStore;

/*
 * Movie file meta data
 * 
 * @author Meinolf Vogt
 */

class Movie {
	/** Movie title. */
	private final String title;
	/** Movie file. */
	private final String moviePath;
	/** MIME type. */
	private final String mimeType;
	/** Movie duration in ms. */
	private final long duration;
	/** Thumbnail file. */
	private final String thumbnailPath;
	/**
	 * Constructor.
	 *
	 * @param mediaCursor
     *      media cursor.
	 * @param thumbnailCursor
	 *      thumbnail cursor.
	 */
	public Movie(Cursor mediaCursor, Cursor thumbnailCursor) {
		title = mediaCursor.getString(mediaCursor
				.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
		moviePath = mediaCursor.getString(mediaCursor
				.getColumnIndex(MediaStore.Video.Media.DATA));
		mimeType = mediaCursor.getString(mediaCursor
				.getColumnIndex(MediaStore.Video.Media.MIME_TYPE));
		duration = mediaCursor.getLong(mediaCursor
				.getColumnIndex(MediaStore.Video.Media.DURATION));

		if ((thumbnailCursor != null) && thumbnailCursor.moveToFirst()) {
			thumbnailPath = thumbnailCursor.getString(thumbnailCursor
					.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
		} else {
			thumbnailPath = null;
		}
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the moviePath
	 */
	public String getMoviePath() {
		return moviePath;
	}
	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}
	/**
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}
	/**
	 * @return the thumbnailPath
	 */
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [title=" + title + ", moviePath=" + moviePath
				+ ", mimeType=" + mimeType + ", duration=" + duration
				+ ", thumbnailPath=" + thumbnailPath + "]";
	}

}


