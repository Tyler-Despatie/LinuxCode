#!/usr/bin/python
#Author: Tyler
import urllib.request
import os
import sys
import re
import json
from operator import itemgetter

def extract_seasons(search):
	response = urllib.request.urlopen("http://www.omdbapi.com/?t=" + str(search))
	data = json.loads(response.read().decode('utf-8').encode('cp850','replace').decode('cp850'))
	res = urllib.request.urlopen("http://imdb.com/title/" + data["imdbID"] + "/?ref_=fn_al_tt_1")
	text = res.read().decode('utf-8').encode('cp850','replace').decode('cp850')
	seasons = re.findall(r'(title/[\w]+/episodes\Sseason=(\d)&ref_=tt_eps_sn_\d)[\S]+', text)
	return seasons

def extract_episodes(page):
	response = urllib.request.urlopen("http://imdb.com/" + str(page))
	text = response.read().decode('utf-8').encode('cp850','replace').decode('cp850')
	episodes = re.findall(r'"airdate">[\s]+([\d\w\s.]+)', text)
	return episodes

def main(search):
	text = extract_seasons(str(search).replace(" ", "%20"))
	text = sorted(text, key = itemgetter(1))

	string = ""
	for items in text:
		string = string + " " + items[1]
	print("Seasons" + string + " found.")

	number = int(input("Enter the season number: "))
	episodes = extract_episodes(text[number-1][0])
	for episode in episodes:
		print(str(episode).replace("\n",""))
	return

if __name__ == '__main__':
	try:
		args = sys.argv[1:]
		search = []
		if not args:
			if os.path.exists('text.txt'):
				f = open('text.txt', 'r')
				for line in f.readlines():
					line = line.rstrip('\n')
					print(line)
					main(line)
					print()
			else:
				print("Usage: imdb.py <search>")
		if args:
			for arg in args:
				search.append(arg)
			main(search)
	except:
		print("\nQuitting Search!")
		sys.exit(1)

#day = time.strftime("%d").lstrip('0')
#print(day + time.strftime(" %b") + ". " + time.strftime("%Y"))
